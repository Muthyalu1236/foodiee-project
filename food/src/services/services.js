import axios from 'axios'

// const baseURL = "http://localhost:8080/";

export const validate = (data)=>{
   return axios.post("http://localhost:8080/validate", data);
}

export const isEmailOrPhoneExcists = (data)=>{
    return axios.post("http://localhost:8080/isExcists", data)
}

export const registerUser = (data)=>{
    axios.post("http://localhost:8080/insert", data);
}

export const getFoodItems = (type)=>{
    return axios.get(`http://localhost:8080/food/${type}`);
}


export const insertOrders = (data)=>{
    return axios.post('http://localhost:8080/insertAllOrders',data);
}

export const getAllOrders = ()=>{
    return axios.get('https://localhost:8080/getAllOrders');
}

export const getOrdersByUser = (username)=>{
    return axios.get(`https://localhost:8080/getOrdersBy/${username}`);
}