import axios from 'axios'

// const baseURL = "http://localhost:8080/";

export const validate = (data)=>{
   return axios.post("http://localhost:8080/validate", data);
}

export const registerUser = (data)=>{
    axios.post("http://localhost:8080/insert", data);
}