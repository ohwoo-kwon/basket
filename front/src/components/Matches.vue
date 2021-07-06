<template>
  <div>
    <div>{{match.start_time}}~{{match.finish_time}}</div>
    <div>{{ gymName }}</div>
    <div>{{ gymAddress }}</div>
    <button @click="matchDetail">상세보기</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Matches',
  props: {
    match: Object,
  },
  data : function () {
    return {
      gymName: null,
      gymAddress: null,
    }
  },
  methods: {
    matchDetail: function () {
      this.$router.push({name: 'MatchDetail'}, this.match)
    }
  },
  created: function () {
    axios({
      method: 'get',
      url: `http://127.0.0.1:8000/matches/gym/${this.match.gym}/detail/`
    })
    .then(res => {
      this.gymName = res.data.name
      this.gymAddress = res.data.address
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>

</style>
