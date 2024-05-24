const getData = async() =>{
    const response = await fetch("127.0.0.1:3306/pecas")
    console.log(response);
}