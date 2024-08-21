import {useForm} from 'react-hook-form'
import { Link } from 'react-router-dom';
import { validate } from '../services/services'
import { useNavigate } from 'react-router-dom';

const Login = () => {

    const bgImgStyle = {backgroundImage: "url(/food2.png)", backgroundRepeat: "no-repeat", backgroundSize: "cover", backgroundPosition: "center center", width: "100vw", height: "100vh", position: "absolute", left: 0, top: 0 };

    const navigate = useNavigate();


    //These are props of useForm
    const {
        register,   //registers the fields and helps to perform form validation
        handleSubmit,   //handles submit and returns fields and values as objects
        formState : {errors},  //helps to display error message
        setError,
        clearErrors
    } = useForm();


    //To handle submit
    const onSubmit = async (data)=>{
      const resValue = await validate(data).then((res)=>{return res.data})
      console.log(data)
      console.log(resValue)

      if(resValue == "email"){
        setError('username', {
          type: 'manual',
          message: "Invalid username",
        });
      } else if(resValue == "password"){
        setError('password', {
          type: 'manual',
          message: "Invalid password",
        });
      } else{
        navigate("/")
      }
    }

  return (
    <>
    <div style={bgImgStyle} className="login">


      <form className='box' onSubmit={handleSubmit(onSubmit)}>
        <h2>Login</h2>
        <div className='inputbox'>
            <input
            className='placeholder-white'
            placeholder='username'
            {...register("username", {
              required: "Username is required",
              minLength: {
                value: 6,
                message: "Username must be at least 6 characters",
              },
              maxLength: {
                value: 20,
                message: "Username cannot exceed 20 characters",
              },
            })}
          />
          {/* error message to display if condition is not met */}
          {errors.username && <p><img src="/warning.svg" width={"15px"} alt="" /> {errors.username.message}</p>}

          <input
            className='placeholder-slate-100'
            placeholder='password'
            type='password'
            {...register("password", {
              required: "Password is required",
              minLength: {
                value: 3,
                message: "Password must be at least 3 characters",
              },
            })}
          />
          {errors.password && <p>{errors.password.message}</p>}
        </div>
        <div className='sign-buttons bg-slate-50'>
            <input className='signin' type="submit" value="Sign in"/>

            {/* to navigate to register page */}
            <Link className='register' to="/register">Register</Link>    
        </div>
    </form>
    </div>
    </>
  )
}

export default Login