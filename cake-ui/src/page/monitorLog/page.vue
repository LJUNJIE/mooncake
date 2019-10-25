<template>
  <div class="fillcontain" >
      <iframe  id="bdIframe" v-bind:src="reportUrl" frameborder="0" scrolling="no" ></iframe>
  </div>
</template>

<script>
import SwitchRoles from './components/SwitchRoles'
import * as mutils from '@/utils/mUtils'

export default {
  name: 'pagePermission',
  components: { SwitchRoles },
    data() {
        return {
            htmlContent: '',
            reportUrl: 'http://localhost:8761/',
            reportType: ''
        }
    },
  mounted(){
    mutils.setContentHeight(this,this.$refs.contain,210);
      /**
       * iframe-宽高自适应显示
       */
      const oIframe = document.getElementById('bdIframe');
      const deviceWidth = document.documentElement.clientWidth;
      const deviceHeight = document.documentElement.clientHeight;
      oIframe.style.width = (Number(deviceWidth)-220) + 'px'; //数字是页面布局宽度差值
      oIframe.style.height = (Number(deviceHeight)-120) + 'px'; //数字是页面布局高度差
  },
  methods: {
    handleRolesChange() {
      // 没有这个可以匹配的路由"/permission/index"，则会定位到404页面
      this.$router.push({ path: '/permission/index?time=' + +new Date() })
    },   
  }
}
</script>

<style lang="less" scoped>
 .contain{
    background: #fff;
    padding: 20px;
    box-sizing: border-box;
  }
</style>
