import {

BrowserRouter,

Routes,

Route

}

from "react-router-dom";

import DashboardPage
from "../pages/DashboardPage";

import LoginPage
from "../pages/LoginPage";

import ProductPage
from "../pages/ProductPage";

import WarehousePage
from "../pages/WarehousePage";

import InventoryPage
from "../pages/InventoryPage";

function AppRoutes()
{

return(

<BrowserRouter>

<Routes>

<Route
path="/"
element={<DashboardPage/>}
/>

<Route
path="/login"
element={<LoginPage/>}
/>

<Route
path="/products"
element={<ProductPage/>}
/>

<Route
path="/warehouse"
element={<WarehousePage/>}
/>

<Route
path="/inventory"
element={<InventoryPage/>}
/>

</Routes>

</BrowserRouter>

);

}

export default AppRoutes;