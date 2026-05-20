import Navbar
from "../components/Navbar";

import Sidebar
from "../components/Sidebar";

import DashboardCard
from "../components/DashboardCard";

function DashboardPage()
{

return(

<div>

<Navbar/>

<div
style={{
display:"flex"
}}
>

<Sidebar/>

<div>

<DashboardCard
title="Products"
/>

<DashboardCard
title="Warehouse"
/>

<DashboardCard
title="Inventory"
/>

</div>

</div>

</div>

);

}

export default DashboardPage;