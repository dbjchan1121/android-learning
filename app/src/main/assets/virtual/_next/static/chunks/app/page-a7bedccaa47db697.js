(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[974],{153:(e,t,s)=>{Promise.resolve().then(s.bind(s,9164))},9164:(e,t,s)=>{"use strict";s.r(t),s.d(t,{default:()=>o});var r=s(5155),a=s(6766),n=s(1250),i=s(2115),l=function(e){return e[e.ACTIVE=1]="ACTIVE",e[e.INACTIVE=0]="INACTIVE",e}({});let c=async()=>{let e=await fetch("http://192.168.1.33:8080/api/getUserList");return await e.json()};function o(){let e=(0,i.useRef)(null),[t,s]=(0,i.useState)([]),o=e=>{s(t=>t.filter((t,s)=>s!==e))},d=e=>{s(t=>t.map((t,s)=>s===e?{...t,status:t.status===l.ACTIVE?l.INACTIVE:l.ACTIVE}:t))},h=(0,n.Te)({count:t.length,getScrollElement:()=>e.current,estimateSize:()=>72,overscan:30,initialRect:{width:0,height:0},scrollPaddingStart:0,scrollPaddingEnd:0});return(0,i.useEffect)(()=>{c().then(e=>{0===e.code&&s(e.data)})},[]),(0,r.jsx)("div",{ref:e,style:{height:"100vh",overflow:"auto"},children:(0,r.jsx)("div",{style:{height:"".concat(h.getTotalSize(),"px"),width:"100%",position:"relative"},children:h.getVirtualItems().map(e=>{let s=t[e.index];return s&&(0,r.jsxs)("div",{className:"flex items-center px-4 h-[72px] border-b border-black/10",style:{position:"absolute",top:0,left:0,width:"100%",transform:"translateY(".concat(e.start,"px)")},children:[(0,r.jsx)(a.default,{src:s.avatar,alt:s.name,width:44,height:44,loading:"lazy",className:"rounded-l"}),(0,r.jsxs)("div",{className:"ml-3 flex-1",children:[(0,r.jsx)("p",{className:"font-semibold",children:s.name}),(0,r.jsxs)("p",{className:"text-gray-500 text-sm",children:["ID: ",s.id]})]}),(0,r.jsxs)("div",{className:"flex items-center gap-2",children:[(0,r.jsx)("button",{onClick:()=>d(e.index),className:"w-[71px] h-[32px] rounded border ".concat(s.status===l.ACTIVE?"border-none text-[#669900]":"border-[#ebebeb] text-black"),children:s.status===l.ACTIVE?"Accepted":"Accept"}),(0,r.jsx)("button",{onClick:()=>o(e.index),className:"w-6 h-6 flex items-center justify-center text-gray-400 hover:text-gray-600",children:(0,r.jsx)("svg",{width:"16",height:"16",viewBox:"0 0 16 16",fill:"none",xmlns:"http://www.w3.org/2000/svg",children:(0,r.jsx)("path",{d:"M12 4L4 12M4 4L12 12",stroke:"currentColor",strokeWidth:"1.5",strokeLinecap:"round",strokeLinejoin:"round"})})})]})]},e.key)})})})}}},e=>{var t=t=>e(e.s=t);e.O(0,[53,441,684,358],()=>t(153)),_N_E=e.O()}]);