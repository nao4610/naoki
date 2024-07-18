<script>
import MyButton from './basics/MyButton.vue'

export default {
  components: {
    MyButton,
  },
  emits: ['delete-done', 'add-todo'],
  data() {
    return {
      newTodoText: '',
    }
  },
  methods: {
    addTodo() {
      this.$emit('add-todo', this.newTodoText);
      this.newTodoText = '';
    },
  },
}
</script>

<template>
  <input type="text" v-model="newTodoText" />
  <MyButton @click="addTodo">追加</MyButton>
  <br>
  <MyButton @click="$emit('delete-done')">完了済みを削除する</MyButton>
</template>
