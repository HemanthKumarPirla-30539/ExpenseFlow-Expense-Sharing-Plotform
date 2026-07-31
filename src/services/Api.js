import axios from "axios";
const API=axios.create({
    baseURL:"http://localhost:2332"
});
export default API;