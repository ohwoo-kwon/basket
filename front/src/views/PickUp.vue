<template>
  <div>
    <Dates />
    <Matches v-for="(match, idx) in matches" :key="idx" :match="match"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Matches from '@/components/Matches.vue'
import Dates from '@/components/Dates.vue'
import axios from 'axios'

export default {
  name: 'Home',
  components: {
    Matches,
    Dates,
  },
  data: function () {
    return {
      matches : null,
      dates : null,
    }
  },
  created: function () {
    const today = new Date();
    console.log(today.getDate())
    console.log(today.getDate()+1)
    console.log(today.getDate()+2)


    axios({
      method: 'get',
      url: 'http://127.0.0.1:8000/matches/match/all/',
    })
    .then(res => {
      this.matches = res.data
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>

</style>