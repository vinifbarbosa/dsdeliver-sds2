import { write } from "fs";
import { useState } from "react";

//toda vez que precisa ter variavel dentro do component,use useState.
function Counter() {
    const [counter, setCounter] = useState(0); //estado counter para receber a contagem 0(ou numero que quiser)  no html

    const handleIncrease = () => {
        setCounter(counter + 1) //atualizando o contador na pagina 
        
         
}

    const handleDecrease = () => {
       setCounter(counter - 1)
       
    }

    return (
        <div>
        <button onClick={handleIncrease}>Incrementar</button>
        <button onClick={handleDecrease}>Decrementar</button>
        <h1>Valor do Contador: {counter}</h1> 
        </div>
    )
};

export default Counter;