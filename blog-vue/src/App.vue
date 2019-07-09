<template>
    <div id="app">
        <div>
            <Register/>
            <Login/>
        </div>

    </div>
</template>

<script>
    import Register from './views/pages/register'
    import Login from './views/pages/login'

    export default {
        name: 'app',
        components: {
            Register,
            Login
        }
    }
</script>

<style>
    body {
        background-color: #E4E5E6
    }
</style>
