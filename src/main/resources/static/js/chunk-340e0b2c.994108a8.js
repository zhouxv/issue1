(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-340e0b2c"],{"01a8":function(e,t,n){"use strict";var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-submenu",{attrs:{index:e.menu.path||e.uniqueId}},[n("template",{slot:"title"},[e.menu.icon?n("i",{class:"fa fa-"+e.menu.icon}):e.menu.iconSvg?n("d2-icon-svg",{attrs:{name:e.menu.iconSvg}}):n("i",{staticClass:"fa fa-folder-o"}),n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.menu.title))])],1),e._l(e.menu.children,(function(e,t){return[void 0===e.children?n("d2-layout-header-aside-menu-item",{key:t,attrs:{menu:e}}):n("d2-layout-header-aside-menu-sub",{key:t,attrs:{menu:e}})]}))],2)},i=[],s=n("a14a"),u=n("73eb"),r={name:"d2-layout-header-aside-menu-sub",components:{"d2-layout-header-aside-menu-item":u["a"]},props:{menu:{type:Object,required:!1,default:function(){}}},data:function(){return{uniqueId:Object(s["uniqueId"])("d2-menu-empty-")}}},o=r,c=n("c701"),l=Object(c["a"])(o,a,i,!1,null,null,null);t["a"]=l.exports},"73eb":function(e,t,n){"use strict";var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-menu-item",{attrs:{index:e.menu.path||e.uniqueId}},[e.menu.icon?n("i",{class:"fa fa-"+e.menu.icon}):e.menu.iconSvg?n("d2-icon-svg",{attrs:{name:e.menu.iconSvg}}):n("i",{staticClass:"fa fa-file-o"}),n("span",{attrs:{slot:"title"},slot:"title"},[e._v(e._s(e.menu.title||"未命名菜单"))])],1)},i=[],s=n("a14a"),u={name:"d2-layout-header-aside-menu-item",props:{menu:{type:Object,required:!1,default:function(){}}},data:function(){return{uniqueId:Object(s["uniqueId"])("d2-menu-empty-")}}},r=u,o=n("c701"),c=Object(o["a"])(r,a,i,!1,null,null,null);t["a"]=c.exports},b55f:function(e,t,n){"use strict";var a=n("c276");t["a"]={methods:{handleMenuSelect:function(e,t){/^d2-menu-empty-\d+$/.test(e)||void 0===e?this.$message.warning("临时菜单"):/^https:\/\/|http:\/\//.test(e)?a["a"].open(e):this.$router.push({path:e})}}}},f6d6:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"d2-layout-header-aside-menu-side"},[n("el-menu",{ref:"menu",attrs:{collapse:e.asideCollapse,"unique-opened":!0,"default-active":e.active},on:{select:e.handleMenuSelect}},[e._l(e.aside,(function(e,t){return[void 0===e.children?n("d2-layout-header-aside-menu-item",{key:t,attrs:{menu:e}}):n("d2-layout-header-aside-menu-sub",{key:t,attrs:{menu:e}})]}))],2),0!==e.aside.length||e.asideCollapse?e._e():n("div",{staticClass:"d2-layout-header-aside-menu-empty",attrs:{flex:"dir:top main:center cross:center"}},[n("d2-icon",{attrs:{name:"inbox"}}),n("span",[e._v("没有侧栏菜单")])],1)],1)},i=[],s=(n("5ab2"),n("6d57"),n("e10e"),n("28f8")),u=n("9f3a"),r=n("b55f"),o=n("73eb"),c=n("01a8"),l=n("ecd2");function d(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function m(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?d(Object(n),!0).forEach((function(t){Object(s["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):d(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var f={name:"d2-layout-header-aside-menu-side",mixins:[r["a"]],components:{"d2-layout-header-aside-menu-item":o["a"],"d2-layout-header-aside-menu-sub":c["a"]},data:function(){return{active:"",asideHeight:300,BS:null}},computed:m({},Object(u["e"])("d2admin/menu",["aside","asideCollapse"])),watch:{asideCollapse:function(e){var t=this;this.scrollDestroy(),setTimeout((function(){t.scrollInit()}),500)},"$route.matched":{handler:function(e){var t=this;this.active=e[e.length-1].path,this.$nextTick((function(){t.aside.length>0&&(t.$refs.menu.activeIndex=t.active)}))},immediate:!0}},mounted:function(){this.scrollInit()},beforeDestroy:function(){this.scrollDestroy()},methods:{scrollInit:function(){this.BS=new l["a"](this.$el,{mouseWheel:!0})},scrollDestroy:function(){try{this.BS.destroy()}catch(e){delete this.BS,this.BS=null}}}},h=f,p=n("c701"),b=Object(p["a"])(h,a,i,!1,null,null,null);t["default"]=b.exports}}]);
//# sourceMappingURL=chunk-340e0b2c.994108a8.js.map