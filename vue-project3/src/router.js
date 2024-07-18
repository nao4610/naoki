import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import ProductListView from '@/views/ProductListView.vue';
import ProductDetailView from '@/views/ProductDetailView.vue';
import AddProductView from '@/views/AddProductView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/products',
    name: 'products',
    component: ProductListView
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetailView,
    props: true
  },
  {
    path: '/add-product',
    name: 'add-product',
    component: AddProductView
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL), // Viteの環境変数を使用
  routes
});

export default router;