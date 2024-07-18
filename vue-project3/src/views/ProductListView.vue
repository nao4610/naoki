<template>
  <div class="product-list-container">
    <h1>出品リスト</h1>
    <div class="search-container">
      <input type="text" class="form-control" v-model="searchName" placeholder="商品名を検索" />
      <div class="form-group">
        <label for="category">商品カテゴリ</label>
        <select id="category" class="form-control" v-model="searchCategory">
          <option value="">すべて</option>
          <option v-for="category in categories" :key="category">{{ category }}</option>
        </select>
      </div>
      <div class="form-group">
        <label for="minPrice">最低金額</label>
        <input type="number" id="minPrice" class="form-control" v-model="searchMinPrice" />
      </div>
      <div class="form-group">
        <label for="maxPrice">最高金額</label>
        <input type="number" id="maxPrice" class="form-control" v-model="searchMaxPrice" />
      </div>
      <div class="form-check">
        <input type="checkbox" class="form-check-input" v-model="showOnlyUnsold" id="showOnlyUnsold" />
        <label class="form-check-label" for="showOnlyUnsold">購入可能な商品だけ表示</label>
      </div>
    </div>

    <div class="product-grid">
      <div class="product-card" v-for="(product, index) in filteredProducts" :key="index">
        <img :src="product.URL" class="product-img" @click="$router.push(`/products/${index}`)" />
        <div class="product-info">
          <h5 class="product-title" :class="{'sold': product.isSold}">{{ product.goods }}</h5>
          <p class="product-category">{{ product.category }}</p>
          <p class="product-price">{{ product.price }}円</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { inject, defineComponent } from 'vue';

export default defineComponent({
  data() {
    return {
      searchName: "",
      searchCategory: "",
      searchMinPrice: "",
      searchMaxPrice: "",
      showOnlyUnsold: false,
      categories: ["携帯電話", "家電", "家具", "書籍", "衣服", "スポーツ用品"]
    };
  },
  setup() {
    const products = inject('products');

    return {
      products
    };
  },
  computed: {
    filteredProducts() {
      return this.products
        .filter(product => {
          return (
            (!this.searchName || product.goods.includes(this.searchName)) &&
            (!this.searchCategory || product.category === this.searchCategory) &&
            (!this.searchMinPrice || product.price >= this.searchMinPrice) &&
            (!this.searchMaxPrice || product.price <= this.searchMaxPrice) &&
            (!this.showOnlyUnsold || !product.isSold)
          );
        })
        .sort((a, b) => a.isSold - b.isSold);
    }
  }
});
</script>

<style>
.product-list-container {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  max-width: 1200px;
}

.search-container {
  margin-bottom: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.form-group, .form-check {
  margin-bottom: 1rem;
}

.form-control {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.form-check-label {
  margin-left: 0.5rem;
}

.product-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 1rem;
}

.product-card {
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  cursor: pointer;
  transition: transform 0.3s;
}

.product-card:hover {
  transform: scale(1.05);
}

.product-img {
  width: 100%;
  height: 150px;
  object-fit: cover;
}

.product-info {
  padding: 1rem;
}

.product-title {
  font-size: 1.25rem;
  margin-bottom: 0.5rem;
}

.product-category,
.product-price {
  margin-bottom: 0.25rem;
}

.sold {
  text-decoration: line-through;
  color: red;
}
</style>