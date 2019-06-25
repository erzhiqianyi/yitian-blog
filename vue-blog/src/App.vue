<template>
  <div id="app">
    <Register/>
  </div>
</template>

<script>
import Login from './views/pages/login'
import Register from './views/pages/register'

export default {
  name: 'app',
  components: {
    Login,
    Register
  }
}
</script>

<style  lang="scss">
$simple-line-font-path: '~simple-line-icons/fonts/';
@import '~simple-line-icons/scss/simple-line-icons.scss';

@import 'assets/scss/style';
</style>
