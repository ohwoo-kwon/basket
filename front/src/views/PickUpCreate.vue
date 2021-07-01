<template>
  <div>
    <h1>픽업 게임 등록</h1>
    <div>
    <div>
      <label for="gym">장소 : </label>
      <span v-for="(gym, idx) in gymList" :key="idx" @click="matchInfo.gym = gym.id">{{ gym.name }} </span>
    </div>
      <label for="date">날짜: </label>
      <input type="date" id="date" v-model="matchInfo.date">
    </div>
    <div>
      <label for="start_time">시작시간 : </label>
      <input type="time" id="start_time" v-model="matchInfo.start_time">
    </div>
    <div>
      <label for="finish_time">종료시간 : </label>
      <input type="time" id="finish_time" v-model="matchInfo.finish_time">
    </div>
    <div>
      <label for="min_people">최소 인원 : </label>
      <input type="number" id="min_people" v-model="matchInfo.min_people">
    </div>
    <div>
      <label for="max_people">최대 인원 : </label>
      <input type="number" id="max_people" v-model="matchInfo.max_people">
    </div>
    <button @click="createMatch">등록</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'PickUpCreate',
  data: function () {
    return {
      matchInfo: {
        date: null,
        start_time: null,
        finish_time: null,
        min_people: null,
        max_people: null,
        gym: null,
      },
      gymList: null,
    }
  },
  methods: {
    setToken: function () {
      const token = localStorage.getItem('jwt')
      const config = {
        Authorization: `JWT ${token}`
      }
      return config
    },
    createMatch: function () {
      const headers = this.setToken()

      axios({
        method: 'post',
        url: 'http://127.0.0.1:8000/matches/match/',
        data: this.matchInfo,
        headers,
      })
      .then(() => {
        this.$router.push({ name: 'Home' })
      })
      .catch(err => {
        console.log(err)
      })
    }
  },
  created: function () {
    const headers = this.setToken()

    axios({
      method: 'get',
      url: 'http://127.0.0.1:8000/matches/',
      headers,
    })
    .then(res => {
      this.gymList = res.data
    })
    .catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>

</style>