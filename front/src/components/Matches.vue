<template>
  <div>
    {{ match }}
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Matches',
  props: {
    match: Object,
  },
  created: function () {
    axios({
      method: 'get',
      url: `http://127.0.0.1:8000/matches/gym/${this.match.gym}/detail/`
    })
    .then(res => {
      this.match.gym = res.data.name
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>

</style>
