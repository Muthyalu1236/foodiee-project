
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

        return ordersList;
    };

    const insertCartToDatabase = () => {
        const ordersList = convertCartToDbFormat();
        setCartDb(ordersList);
        setCartItems({});
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

