import { useContext } from 'react'
import './Payment.css'
import PaymentForm from './PaymentForm'
import { StoreContext } from '../../context/StoreContext'
import { insertOrders } from '../../services/services'
import { useNavigate } from 'react-router-dom'


const Payment = () => {

    const navigate = useNavigate();

    const {insertCartToDatabase, cartDb, totalPayable} = useContext(StoreContext);

    const handleClick = async ()=>{
        console.log("before calling")
        insertCartToDatabase();
        const resData = await insertOrders(cartDb);
        console.log(resData);
        console.log("After calling")
        navigate("/thankyou")
    }

  return (
    <div className='payment-container'>
        <div className="payment-gateway">
            <div className="payment-form">
                <PaymentForm />
            </div>
            <div className="payment-button">
                <button className='pay-button' disabled={totalPayable <= 0 && true} onClick={handleClick} >Pay {totalPayable > 0 ? `₹${totalPayable}` : ""}</button>
            </div>
        </div>
    </div>
  )
}

export default Payment