function LoginPage()
{

return(

<div
style={{

display:"flex",

justifyContent:"center",

alignItems:"center",

height:"100vh",

background:"#e5e7eb"

}}
>

<div
style={{

background:"white",

padding:"30px",

borderRadius:"12px",

width:"300px"

}}
>

<h2>

Login

</h2>

<input

placeholder="Username"

style={{

width:"100%",

padding:"10px",

margin:"10px 0"

}}
/>

<input

placeholder="Password"

type="password"

style={{

width:"100%",

padding:"10px",

margin:"10px 0"

}}
/>

<button
style={{

width:"100%",

padding:"10px",

background:"#2563eb",

color:"white"

}}
>

Login

</button>

</div>

</div>

);

}

export default LoginPage;