// import { useState } from 'react'

// import { createContext } from 'react'

// export const StoreContext = createContext(null);

// const StoreContextProvider = (props) => {

//     const [userName, setUserName] = useState("");

//     const [cartItems, setCartItems] = useState({});

//     const addToCart = (itemName)=>{
//         if(!cartItems[itemName]){
//             setCartItems((prev)=>({...prev, [itemName]:1}))
//             console.log(cartItems)
//         } else{
//             setCartItems((prev)=>({...prev, [itemName]:prev[itemName]+1}))
//             console.log(cartItems)
//         }
//     }

//     // const removeFromCart = (itemName)=>{
//     //     setCartItems((prev)=>({...prev, [itemName]:prev[itemName]-1}))
//     // }

//     const removeFromCart = (itemName)=>{
//         setCartItems((prev)=>{

//             const updateCartItem = {...prev};

//             if(updateCartItem[itemName] > 1){
//                 return {...updateCartItem, [itemName]:updateCartItem[itemName]-1};
                
//             } else{
//                 delete updateCartItem[itemName];
//                 return {...updateCartItem}
//             }
//         })

//             // ({...prev, [itemName]:prev[itemName]-1})
//     }

//     const contextValue = {
//         userName,
//         setUserName,
//         cartItems,
//         setCartItems,
//         addToCart,
//         removeFromCart
//     }

//     return (
//         <StoreContext.Provider value={contextValue} >
//             {props.children}
//         </StoreContext.Provider>
//     )

// }

// export default StoreContextProvider;


import { useState, useEffect, createContext } from 'react';

export const StoreContext = createContext(null);

const StoreContextProvider = (props) => {
    const [userName, setUserName] = useState("");
    const [cartItems, setCartItems] = useState({});

    const [cartDb, setCartDb] = useState([]);

    const [totalPayable, setTotalPayable] = useState(0);

    useEffect(() => {
        let cost = 0;
        Object.entries(cartItems).forEach(([itemName, { quantity, price }]) => {
            cost += price * quantity;
        });
        setTotalPayable(cost);
    
    }, [cartItems])
    


    // const updateTotalPrice = ()=>{
    //     let cost = 0;
    //     Object.entries(cartItems).forEach(([itemName, { quantity, price }]) => {
    //         cost += price * quantity;
    //     });
    //     setTotalPayable(cost);
    // }

    // const updateTotalPrice = () => {
    //     let cost = 0; // Initialize cost to 0
    //     Object.entries(cartItems).forEach(([itemName, { quantity, price }]) => {
    //         cost += price * quantity;
    //     });
    //     setTotalPayable(cost);
    // };

    // useEffect(() => {
    //     updateTotalPrice();
    // }, [cartItems, updateTotalPrice]);

    const addToCart = (itemName, price) => {
        setCartItems((prev) => {

            const existingItem = prev[itemName] || { quantity: 0, price };
            const updatedCartItems = {
                ...prev,
                [itemName]: {
                    quantity: existingItem.quantity + 1,
                    price: existingItem.price,
                }
            };

            console.log(updatedCartItems)

            return updatedCartItems;
        });
    };

    const removeFromCart = (itemName) => {
        setCartItems((prev) => {

            const existingItem = prev[itemName];

            const updatedCartItems = { ...prev };

            if (existingItem.quantity > 1) {
                updatedCartItems[itemName] = {
                    ...existingItem,                           //this line spreads the price component
                    quantity: existingItem.quantity - 1,
                };
            } else {
                delete updatedCartItems[itemName];
            }

            console.log(updatedCartItems);

            return updatedCartItems;
        });
    };

    const convertCartToDbFormat = () => {
        const ordersList = Object.entries(cartItems).map(([itemName, { quantity, price }]) => ({
            username: userName,
            fooditem: itemName,
            quantity: quantity,
            price: price
        }));

        console.log(ordersList);

        return ordersList;
    };

    const insertCartToDatabase = () => {
        const ordersList = convertCartToDbFormat();
        console.log('Inserting the following into database:', ordersList);
        setCartDb(ordersList);
    };

    const contextValue = {
        userName,
        setUserName,
        cartItems,
        setCartItems,
        addToCart,
        removeFromCart,
        cartDb,
        insertCartToDatabase,
        totalPayable
    };

    return (
        <StoreContext.Provider value={contextValue}>
            {props.children}
        </StoreContext.Provider>
    );
};

export default StoreContextProvider;

