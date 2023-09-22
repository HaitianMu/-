import axios from "axios";

const api = axios.create({
    baseURL: "http://47.96.40.35:8082",
    timeout:"5000"
})

export default api