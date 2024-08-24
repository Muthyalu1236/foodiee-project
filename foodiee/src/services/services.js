import axios from 'axios'

// const baseURL = "http://localhost:8080/";

export const validate = (data)=>{
   return axios.post("http://localhost:8080/user/validate", data);
}

export const isEmailOrPhoneExcists = (data)=>{
    return axios.post("http://localhost:8080/user/isExcists", data)
}

export const registerUser = (data)=>{
    axios.post("http://localhost:8080/user/insert", data);
}

export const getFoodItems = (type)=>{
    return axios.get(`http://localhost:8080/food/${type}`);
}


export const insertOrders = (data)=>{
    return axios.post('http://localhost:8080/orders/insertAll',data);
}

export const getAllOrders = ()=>{
    return axios.get('https://localhost:8080/orders/getAll');
}

export const getOrdersByUser = (username)=>{
    return axios.get(`https://localhost:8080/orders/getBy/${username}`);
}