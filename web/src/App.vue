<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
   name: 'App',
}
</script>

<style>
#app, html{
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
  /* margin-top: 60px; */
}
  body{
    height: 100%;
    width: 100%;
    margin: 0;
    padding:0;
    background: #dfe7e948;
  }
</style>
