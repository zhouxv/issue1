(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5d730efb"],{"362c":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{directives:[{name:"show",rawName:"v-show",value:t.flag,expression:"flag"}],staticClass:"d2-contextmenu",style:t.style},[t._t("default")],2)},s=[],o=(n("163d"),{name:"d2-contextmenu",props:{visible:{type:Boolean,default:!1},x:{type:Number,default:0},y:{type:Number,default:0}},computed:{flag:{get:function(){return this.visible&&window.addEventListener("mousedown",this.watchContextmenu),this.visible},set:function(t){this.$emit("update:visible",t)}},style:function(){return{left:this.x+"px",top:this.y+"px",display:this.visible?"block":"none "}}},methods:{watchContextmenu:function(t){this.$el.contains(t.target)&&0===t.button||(this.flag=!1),window.removeEventListener("mousedown",this.watchContextmenu)}},mounted:function(){document.querySelector("body").appendChild(this.$el)}}),u=o,a=(n("a887"),n("c701")),l=Object(a["a"])(u,i,s,!1,null,null,null);e["default"]=l.exports},"9ca3":function(t,e,n){},a887:function(t,e,n){"use strict";n("9ca3")}}]);
//# sourceMappingURL=chunk-5d730efb.fc676575.js.map