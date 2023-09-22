import api from "./api.js"

const user={
    login(data){
        return api.post('/userinfo/login',data)
    },
    register(data){
        return api.post('/userinfo/register',data)
    }
}

export default user