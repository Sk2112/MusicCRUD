import React from 'react';
import { useNavigate } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate();

  return (
    <div className="container text-center mt-5"
     style={{backgroundColor:"#f0f8ff"}}>
      <h1>Welcome to Music App 🎵</h1>
      <button 
        className="btn btn-primary mt-3"
        onClick={() => navigate('/music')}
      >
        Get Started
      </button>
    </div>
  );
};

export default Home;
