import { Link }

from "react-router-dom";

function Sidebar()
{

return(

<div
style={{

width:"220px",

height:"100vh",

background:"#1f2937",

padding:"20px"

}}
>

<h3
style={{
color:"white"
}}
>

Menu

</h3>

<p>

<Link
to="/"

style={{
color:"white"
}}
>

Dashboard

</Link>

</p>

<p>

<Link
to="/products"

style={{
color:"white"
}}
>

Products

</Link>

</p>

<p>

<Link
to="/warehouse"

style={{
color:"white"
}}
>

Warehouse

</Link>

</p>

<p>

<Link
to="/inventory"

style={{
color:"white"
}}
>

Inventory

</Link>

</p>

</div>

);

}

export default Sidebar;