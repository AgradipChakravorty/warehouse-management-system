import {

Link

}

from "react-router-dom";

function Sidebar()
{

return(

<div

style={{

width:"200px",

height:"100vh",

background:"#e5e7eb",

padding:"20px"

}}

>

<p>

<Link to="/">

Dashboard

</Link>

</p>

<p>

<Link to="/products">

Products

</Link>

</p>

<p>

<Link to="/warehouse">

Warehouse

</Link>

</p>

<p>

<Link to="/inventory">

Inventory

</Link>

</p>

</div>

);

}

export default Sidebar;