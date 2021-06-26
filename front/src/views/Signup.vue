<template>
  <div>
    <h1>Signup</h1>
    <div>
      <label for="username">이메일 주소: </label>
      <input type="text" id="username" v-model="credentials.username">
    </div>
    <div>
      <label for="password">비밀번호: </label>
      <input type="password" id="password" v-model="credentials.password">
    </div>
    <div>
      <label for="password2">비밀번호 확인: </label>
      <input type="password" id="password2" v-model="credentials.passwordConfirmation">
    </div>
    <div>
      <label for="last_name">성: </label>
      <input type="text" id="last_name" v-model="credentials.last_name">
    </div>
    <div>
      <label for="first_name">이름: </label>
      <input type="text" id="first_name" v-model="credentials.first_name">
    </div>
    <div>
      <label for="birth">출생년월일: </label>
      <input type="text" id="birth" v-model="credentials.birth">
    </div>
    <div>
      <label for="phone_number">연락처: </label>
      <input type="text" id="phone_number" v-model="credentials.phone_number" @keyup.enter="signup">
    </div>
    <button @click="signup">회원가입</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Signup',
  data: function () {
    return {
      credentials: {
        username: null,
        last_name: null,
        first_name: null,
        password: null,
        passwordConfirmation: null,
        is_gym: false,
        phone_number: null,
        birth: null,
      }
    }
  },
  methods: {
    signup: function () {
      axios({
        method: 'post',
        url: 'http://127.0.0.1:8000/accounts/signup/',
        data: this.credentials,
      })
      .then(() => {
        this.$router.push({ name: 'Login' })
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