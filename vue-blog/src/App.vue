<template>
  <div id="app">
    <Login/>
  </div>
</template>

<script>
import Login from './views/pages/login'

export default {
  name: 'app',
  components: {
    Login
  }
}
</script>

<style  lang="scss">
$simple-line-font-path: '~simple-line-icons/fonts/';
@import '~simple-line-icons/scss/simple-line-icons.scss';

@import 'assets/scss/style';
</style>
