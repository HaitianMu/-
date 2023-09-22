import api from "./api.js"

const company = {
    searchCompany(data){
        return api.post('/company/searchresult',data)
    },
    searchDetails(data){
        return api.post('/company1/details',data)
    },
    searchCompanyAdminister(data){
        return api.post('/company1/administrater',data)
    },
    searchHolder(data){
        return api.post('/company2/holders',data)
    },
    searchall(){
        return api.post('/company/allData')
    },
    areaAnalysis(data){
        return api.post('/company/areaAnalysis',data)
    }
}

export default company