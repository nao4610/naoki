<template>
  <div id="app">
    <nav class="navbar">
      <div class="navbar-container">
        <a class="navbar-brand" >Nyahooフリマ</a>
        <div class="navbar-links">
          <button class="btn" @click="$router.push('/')">Home</button>
          <button class="btn" @click="$router.push('/products')">商品リスト</button>
          <button class="btn" @click="$router.push('/add-product')">商品を追加</button>
        </div>
      </div>
    </nav>
    <div class="container">
      <router-view/> <!-- ルーターのビュー -->
    </div>
  </div>
</template>

<script>
import { reactive, provide, defineComponent, onMounted } from 'vue';

export default defineComponent({
  name: 'App',
  setup() {
    const products = reactive([
      {
        goods: "スマホ",
        URL: "https://www.asahibeer.co.jp/news/2021/image/0106_2bla.jpg",
        category: "携帯電話",
        explanation: "中古",
        price: 30000,
        exhibitor: "なお",
        password: "1234",
        isSold: false,
        createdAt: new Date(Date.now() - 1000 * 60 * 60 * 50) // 50 hours ago
      }
    ]);

    const addProduct = (product) => {
      products.push(product);
    };

    const editProduct = (index, product) => {
      products[index] = product;
    };

    const markAsSold = (index) => {
      if (products[index]) {
        products[index].isSold = true;
      } else {
        console.warn(`Product with index ${index} not found`);
      }
    };

    const checkProducts = () => {
      const now = Date.now();
      products.forEach((product, index) => {
        const hoursElapsed = (now - new Date(product.createdAt).getTime()) / (1000 * 60 * 60);
        
        // 出品後48時間経過したら価格を半額にする
        if (hoursElapsed >= 48 && hoursElapsed < 72 && !product.isSold) {
          product.price /= 2;
        }

        // 出品後72時間経過したら出品取消
        if (hoursElapsed >= 72 && !product.isSold) {
          products.splice(index, 1);
        }
      });
    };

    // 1時間ごとにチェックする
    setInterval(checkProducts, 1000 * 60 * 60);

    onMounted(() => {
      checkProducts();
    });

    provide('products', products);
    provide('addProduct', addProduct);
    provide('editProduct', editProduct);
    provide('markAsSold', markAsSold);
  }
});
</script>

<style>
body {
  font-family: 'Roboto', sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f0f2f5;
}

.navbar {
  background-color: #343a40;
  padding: 1rem;
  color: white;
  text-align: center;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.navbar-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navbar-brand {
  font-size: 1.5rem;
  font-weight: bold;
}

.navbar-links {
  display: flex;
  gap: 1rem;
}

.btn {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  cursor: pointer;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.btn:hover {
  background-color: #0056b3;
}

.container {
  padding: 2rem;
  max-width: 1200px;
  margin: 0 auto;
}
</style>