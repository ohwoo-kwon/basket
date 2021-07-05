<template>
  <div>
    <div class="dates">
      <Dates v-for="date in dates" :key="date[1]" :date="date"
        @checkDate="checkDate" />
    </div>
    <Matches v-for="(match, idx) in showMatches" :key="idx" :match="match" class="match"/>
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
      matches : Array,
      dates : [],
      day_list : ['일', '월', '화', '수', '목', '금', '토', '일'],
      showMatches: null,
    }
  },
  methods: {
    checkDate: function (date) {
      // console.log(date)
      this.showMatches = this.matches.filter(match => match.date === date)
    }
  },
  created: function () {
    const today = new Date()
    let year = today.getFullYear()
    let month = today.getMonth() + 1
    let date = today.getDate()
    let day = this.day_list[today.getDay()]
    let todayInfo = `${year}-${month > 9 ? month:'0'+month }-${date > 9 ? date:'0'+date}`

    let date_info = [todayInfo, date, day]
    this.dates.push(date_info)

    var i = 1
    while (i<7) {
      today.setDate(today.getDate() + 1)
      year = today.getFullYear()
      month = today.getMonth() + 1
      date = today.getDate()
      day = this.day_list[today.getDay()]
      todayInfo = `${year}-${month > 9 ? month:'0'+month }-${date > 9 ? date:'0'+date}`

      date_info = [todayInfo, date, day]
      this.dates.push(date_info)
      i ++
    }

    axios({
      method: 'get',
      url: 'http://127.0.0.1:8000/matches/match/all/',
    })
    .then(res => {
      this.matches = res.data
      this.checkDate(todayInfo)
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>
.dates {
  display: flex;
  justify-content: space-around;
  max-width: 1024px;
  margin: 0 auto;
}

.dates > div {
  margin: 1rem;
}

.match {
  display: flex;
  justify-content: space-around;
  max-width: 1024px;
  margin: 0 auto;
}
</style>