<template>
    <div class="form-container">
      <h1>出品登録</h1>
      <form @submit.prevent="addProductHandler">
        <div class="form-group">
          <label for="exhibitor">出品者</label>
          <input type="text" id="exhibitor" v-model="newExhibitor" class="form-control" />
        </div>
        <div class="form-group">
          <label for="goods">商品名</label>
          <input type="text" id="goods" v-model="newGoods" class="form-control" />
        </div>
        <div class="form-group">
          <label for="url">URL</label>
          <input type="text" id="url" v-model="newURL" class="form-control" />
        </div>
        <div class="form-group">
          <label for="category">商品カテゴリ</label>
          <select id="category" v-model="newCategory" class="form-control">
            <option disabled value="">選択してください</option>
            <option v-for="category in categories" :key="category">{{ category }}</option>
          </select>
        </div>
        <div class="form-group">
          <label for="explanation">商品説明</label>
          <input type="text" id="explanation" v-model="newExplanation" class="form-control" />
        </div>
        <div class="form-group">
          <label for="price">金額</label>
          <input type="number" id="price" v-model="newPrice" class="form-control" />
        </div>
        <div class="form-group">
          <label for="password">パスワード</label>
          <input type="password" id="password" v-model="newPassword" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">出品</button>
        <button type="button" class="btn btn-secondary" @click="$router.push('/products')">出品リストを見る</button>
      </form>
    </div>
  </template>
  
  <script>
  import { inject, defineComponent } from 'vue';
  
  export default defineComponent({
    data() {
      return {
        newGoods: "",
        newURL: "",
        newCategory: "",
        newExplanation: "",
        newPrice: "",
        newExhibitor: "",
        newPassword: "",
        categories: ["携帯電話", "家電", "家具", "書籍", "衣服", "スポーツ用品"]
      };
    },
    setup() {
      const addProduct = inject('addProduct');
  
      return {
        addProduct
      };
    },
    methods: {
      addProductHandler() {
        if (this.newExhibitor === '') {
          alert('出品者名を入力してください');
          return;
        }
        if (this.newGoods === '') {
          alert('商品名を入力してください');
          return;
        }
        if (this.newURL === '') {
          alert('URLを入力してください');
          return;
        }
        if (this.newCategory === '') {
          alert('商品カテゴリーを選択してください');
          return;
        }
        if (this.newExplanation === '') {
          alert('商品説明を入力してください');
          return;
        }
        if (this.newPrice === '') {
          alert('金額を入力してください');
          return;
        }
        if (this.newPassword === '') {
          alert('パスワードを入力してください');
          return;
        }
        this.addProduct({
          goods: this.newGoods,
          URL: this.newURL,
          category: this.newCategory,
          explanation: this.newExplanation,
          price: parseFloat(this.newPrice),
          exhibitor: this.newExhibitor,
          password: this.newPassword,
          isSold: false,
          createdAt: new Date()
        });
        this.newGoods = "";
        this.newURL = "";
        this.newCategory = "";
        this.newExplanation = "";
        this.newPrice = "";
        this.newExhibitor = "";
        this.newPassword = "";
        this.$router.push('/products');
      }
    }
  });
  </script>
  
  <style>
  .form-container {
    background-color: white;
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    margin: 0 auto;
  }
  
  .form-group {
    margin-bottom: 1rem;
  }
  
  .form-control {
    width: 100%;
    padding: 0.5rem;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
  }
  
  .btn {
    padding: 0.5rem 1rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
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