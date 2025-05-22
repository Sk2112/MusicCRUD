import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './Components/Home';
import Music from './Components/Music';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
  <BrowserRouter>
  
  <Routes>
    <Route path='/' element={<Home></Home>}/>
    <Route path='/music' element={<Music></Music>}/>
  </Routes>
  
  </BrowserRouter>
  );
}

export default App;
