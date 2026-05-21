function ProductPage()
{

const products=[

{id:1,name:"Laptop",price:50000},

{id:2,name:"Keyboard",price:1500},

{id:3,name:"Mouse",price:700},

{id:4,name:"Monitor",price:12000},

{id:5,name:"Printer",price:15000},

{id:6,name:"Scanner",price:10000}

];

return(

<div
style={{

padding:"30px"

}}
>

<h1>

Products

</h1>

<table
border="1"

style={{

width:"100%",

background:"white"

}}
>

<tr>

<th>ID</th>

<th>Product</th>

<th>Price</th>

</tr>

{

products.map(

p=>(

<tr key={p.id}>

<td>{p.id}</td>

<td>{p.name}</td>

<td>₹{p.price}</td>

</tr>

)

)

}

</table>

</div>

);

}

export default ProductPage;