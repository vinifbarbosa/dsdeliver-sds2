import "./styles.css";
import {ReactComponent as Logo} from "./logo.svg" // jeito facil de importar svg 
import { Link } from "react-router-dom";
function Navbar() {
    return(
        <nav className="main-navbar">
            <Logo />
          <Link to ="/"className="logo-text">DS Deliver</Link>  

        </nav>
    )
}

export default Navbar;