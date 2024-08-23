import './Home.css'
// import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
// import { useEffect } from 'react';
import Navbar from './Navbar/Navbar';
import Header from './Header/Header';
import FoodMenu from './Fooditems/FoodMenu';
import Footer from './Footer/Footer';


const Home = () => {

  // useEffect(() => {
  //   toast.success("Successfully logged in!");
  // },[])
  

    

  return (
    <>

      {/* <ToastContainer /> */}
      <div className="home-container">
        <Navbar />
        <Header />
        <FoodMenu />
        <Footer />
      </div>
        
    </>
  )
}

export default Home