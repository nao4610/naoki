<template>
  <ProductDetail :id="id" />
</template>

<script>
import { defineComponent } from 'vue';
import { useRoute } from 'vue-router';
import ProductDetail from '@/components/pages/ProductDetail.vue';

export default defineComponent({
  components: {
    ProductDetail
  },
  setup() {
    const route = useRoute();
    const id = route.params.id;

    return {
      id
    };
  }
});
</script>