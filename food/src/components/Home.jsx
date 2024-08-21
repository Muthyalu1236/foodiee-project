import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useEffect } from 'react';


const Home = () => {

  useEffect(() => {
    toast.success("Successfully logged in!");
  }, [])
  

    

  return (
    <>
        <ToastContainer />
        <h1>Home page</h1>
        
    </>
  )
}

export default Home