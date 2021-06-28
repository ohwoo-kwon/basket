<template>
  <div class="container">
    <div class="header">
      <img class="logo" src="@/assets/logo.png" alt="logo">
      <div>
        <div v-if="isLogin">
          <router-link to="/pickup/create">픽업 게임 생성</router-link>
          <router-link to="/gym/create">체육관 등록</router-link>
          <router-link @click.native="logout" to="/">로그아웃</router-link>
        </div>
        <div v-else>
          <router-link to="/login">로그인</router-link>
          <router-link to="/signup">회원가입</router-link>
        </div>
      </div>
    </div>
    <div class="nav">
      <router-link to="/">픽업게임</router-link>
    </div>
    <router-view @login="isLogin = true"/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data: function() {
    return {
      isLogin: false,
    }
  },
  methods: {
    logout: function () {
      this.isLogin = false
      localStorage.removeItem('jwt')
      this.$router.push({name: 'Login'})
    }
  },
  created: function () {
    const token = localStorage.getItem('jwt')
    if (token) {
      this.isLogin = true
    }
  }
}
</script>

<style>
.container {
 width: 100%;
 margin: 0 auto;
 text-align: center;
}

.header {
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  max-width: 1024px;
  align-items: center;
}

.logo {
  height: 30px;
}

.header a {
  margin: 1rem;
}

.nav {
  margin: 0 auto;
  max-width: 1024px;
  text-align: start;
  padding: 1rem 0;
  font-size: 1.5rem;
}

a {
  text-decoration: none;
}
</style>
