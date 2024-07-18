<template>
  <div class="product-detail-container" v-if="product">
    <h1>商品詳細</h1>
    <div class="product-card">
      <div class="product-img-container">
        <img :src="product.URL" class="product-img" />
      </div>
      <div class="product-info">
        <h5 class="product-title">{{ product.goods }}</h5>
        <p class="product-category">カテゴリ: {{ product.category }}</p>
        <p class="product-description">説明: {{ product.explanation }}</p>
        <p class="product-price">金額: {{ product.price }}円</p>
        <p class="product-exhibitor">出品者: {{ product.exhibitor }}</p>
        <p class="product-date">出品日時: {{ new Date(product.createdAt).toLocaleString() }}</p>

        <button v-if="!editMode && !product.isSold" class="btn btn-primary" @click="markAsSoldHandler">購入</button>

        <div v-if="!editMode" class="form-group">
          <label for="password">パスワード</label>
          <input type="password" id="password" v-model="editPassword" class="form-control" />
          <button class="btn btn-secondary" @click="enableEdit">編集</button>
        </div>

        <div v-else>
          <form @submit.prevent="saveChanges">
            <div class="form-group">
              <label for="goods">商品名</label>
              <input type="text" id="goods" v-model="product.goods" class="form-control" />
            </div>
            <div class="form-group">
              <label for="category">カテゴリ</label>
              <select id="category" v-model="product.category" class="form-control">
                <option v-for="category in categories" :key="category">{{ category }}</option>
              </select>
            </div>
            <div class="form-group">
              <label for="explanation">説明</label>
              <input type="text" id="explanation" v-model="product.explanation" class="form-control" />
            </div>
            <div class="form-group">
              <label for="price">金額</label>
              <input type="number" id="price" v-model="product.price" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">保存</button>
          </form>
        </div>

        <button class="btn btn-secondary" @click="$router.push('/products')">戻る</button>
      </div>
    </div>
  </div>
</template>

<script>
import { inject, defineComponent } from 'vue';

export default defineComponent({
  props: {
    id: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      product: null,
      editMode: false,
      editPassword: "",
      categories: ["携帯電話", "家電", "家具", "書籍", "衣服", "スポーツ用品"]
    };
  },
  setup(props) {
    const products = inject('products');
    const editProduct = inject('editProduct');
    const markAsSold = inject('markAsSold');

    return {
      products,
      editProduct,
      markAsSold,
      product: products[props.id]
    };
  },
  methods: {
    enableEdit() {
      if (this.product.password === this.editPassword) {
        this.editMode = true;
      } else {
        alert("パスワードが間違っています");
      }
    },
    saveChanges() {
      this.editProduct(this.id, this.product);
      this.editMode = false;
      this.editPassword = "";
    },
    markAsSoldHandler() {
      this.markAsSold(this.id);
      this.$router.push('/products');
    }
  }
});
</script>

<style>
.product-detail-container {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  margin: 0 auto;
  max-width: 800px;
}

.product-card {
  background-color: white;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  overflow: hidden;
}

.product-img-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 300px; /* 画像の高さに合わせる */
}

.product-img {
  width: 200px;
  height: 300px;
  object-fit: cover;
}

.product-info {
  padding: 1rem;
}

.product-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}

.product-category,
.product-description,
.product-price,
.product-exhibitor,
.product-date {
  margin-bottom: 0.5rem;
}

.form-group {
  margin-bottom: 1rem;
}

.form-control {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn {
  padding: 0.5rem 1rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 0.5rem;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s;
}

.btn-primary {
  background-color: #007bff;
  color: white;
}

.btn-secondary {
  background-color: #6c757d;
  color: white;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.btn-secondary:hover {
  background-color: #5a6268;
}
</style>