import { useContext } from 'react'
import './Payment.css'
import PaymentForm from './PaymentForm'
import { StoreContext } from '../../context/StoreContext'
import { insertOrders } from '../../services/services'

const Payment = () => {

    const {insertCartToDatabase} = useContext(StoreContext);
    const {cartDb} = useContext(StoreContext);

    const handleClick = async ()=>{
        console.log("before calling")
        insertCartToDatabase();
        const resData = await insertOrders(cartDb);
        console.log(resData);
        console.log("After calling")
    }

  return (
    <div className='payment-container'>
        <div className="payment-gateway">
            {/* <div className="payment-methods">
                <button>UPI</button>
                <button>credit</button>
                <button>debit</button>
            </div> */}
            <h3>Enter credit card details</h3>
            <div className="payment-form">
                <PaymentForm />
            </div>
            <div className="payment-button">   
                {/* <button type="button" className="btn btn-success">Pay</button> */}
                <button className='pay-button' onClick={handleClick} >Pay</button>
            </div>
        </div>
    </div>
  )
}

export default Payment