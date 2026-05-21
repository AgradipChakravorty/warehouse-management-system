import Navbar
from "../components/Navbar";

import Sidebar
from "../components/Sidebar";

import DashboardCard
from "../components/DashboardCard";

function DashboardPage()
{

return(

<div
style={{

background:"#f3f4f6",

minHeight:"100vh"

}}
>

<Navbar/>

<div
style={{

display:"flex"

}}
>

<Sidebar/>

<div
style={{

padding:"30px",

width:"100%"

}}
>

<h1
style={{

color:"#111827"

}}
>

Warehouse Dashboard

</h1>

<p>

Manage products, inventory and warehouses

</p>

<div
style={{

display:"flex",

gap:"20px",

flexWrap:"wrap",

marginTop:"20px"

}}
>

<div
style={{

background:"#2563eb",

color:"white",

padding:"25px",

borderRadius:"12px",

width:"220px"

}}
>

<h2>

120

</h2>

<p>

Products

</p>

</div>

<div
style={{

background:"#16a34a",

color:"white",

padding:"25px",

borderRadius:"12px",

width:"220px"

}}
>

<h2>

8

</h2>

<p>

Warehouses

</p>

</div>

<div
style={{

background:"#dc2626",

color:"white",

padding:"25px",

borderRadius:"12px",

width:"220px"

}}
>

<h2>

560

</h2>

<p>

Inventory Items

</p>

</div>

</div>

</div>

</div>

</div>

);

}

export default DashboardPage;