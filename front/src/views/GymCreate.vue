<template>
  <div>
    <h1>체육관 등록</h1>
    <div>
      <label for="name">체육관 이름: </label>
      <input type="text" id="name" v-model="gymInfo.name">
    </div>
    <div>
      <label for="address">주소: </label>
      <input type="text" id="address" v-model="gymInfo.address">
    </div>
    <div>
      <label for="court_length">체육관 길이 : </label>
      <input type="number" id="court_length" v-model="gymInfo.court_length">
    </div>
    <div>
      <label for="court_width">체육관 너비 : </label>
      <input type="number" id="court_width" v-model="gymInfo.court_width">
    </div>
    <div>
      <label for="parking">주차 : </label>
      <input type="radio" name="parking" id="parking" checked @click="gymInfo.parking = true"><span>가능</span>
      <input type="radio" name="parking" id="parking" @click="gymInfo.parking = false"><span>불가능</span>
    </div>
    <div>
      <label for="shower">샤워 : </label>
      <input type="radio" name="shower" id="shower" checked @click="gymInfo.shower = true"><span>가능</span>
      <input type="radio" name="shower" id="shower" @click="gymInfo.shower = false"><span>불가능</span>
    </div>
    <div>
      <label for="court-size">코트 사이즈 : </label>
      <input type="radio" name="court-size" id="court-size" checked @click="gymInfo.normal_size = true"><span>정규</span>
      <input type="radio" name="court-size" id="court-size" @click="gymInfo.normal_size = false"><span>작음</span>
    </div>
    <button @click="createGym">등록</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
name: 'GymCreate',
data: function () {
  return {
    gymInfo: {
      name: null,
      address: null,
      court_length: null,
      court_width : null,
      parking: true,
      shower: true,
      normal_size: true,
    }
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
  createGym: function () {
    const headers = this.setToken()

    axios({
      method: 'post',
      url: 'http://127.0.0.1:8000/matches/',
      data: this.gymInfo,
      headers,
    })
    .then(() => {
      this.$router.push('/')
    })
    .catch(err => {
      console.log(err)
    })
  }
}
}
</script>

<style>

</style>