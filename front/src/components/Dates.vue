<template>
  <div @click="showDate">
    <p>{{ date[1] }}</p>
    <p>{{ date[2] }}</p>
  </div>
</template>

<script>
export default {
  name : 'Dates',
  props : {
    date: Array,
  },
  data: function () {
    return {
      checkDate: null,
    }
  },
  methods: {
    showDate: function () {
      this.checkDate = this.date[0]
      this.$emit('checkDate', this.checkDate)
    }
  }
}
</script>

<style>

</style>