function InventoryPage()
{

return(

<div
style={{

padding:"30px"

}}
>

<h1>

Inventory Status

</h1>

<div
style={{

display:"flex",

gap:"20px"

}}
>

<div
style={{

background:"#f59e0b",

padding:"20px",

borderRadius:"10px"

}}
>

Available:
560

</div>

<div
style={{

background:"#10b981",

padding:"20px",

borderRadius:"10px"

}}
>

Incoming:
120

</div>

<div
style={{

background:"#ef4444",

padding:"20px",

borderRadius:"10px"

}}
>

Low Stock:
20

</div>

</div>

</div>

);

}

export default InventoryPage;