<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - FoodieFinder</title>
    <link rel="stylesheet" href="signup.css">
</head>
<body>
    <header>
        <div class="nav">
            <div class="logo">
            <img src="logo.png" width="125px">
        </div>
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a  href="about.html">About Us</a></li>
                <li><a href="support.html">Support</a></li>
            </ul>
            <div>
              <button class="login" onclick="window.location.href='newlogin.html';">Log in</button>
            <button class="signup" onclick="window.location.href='signup.html';">Sign up</button>
          </div>
            </div>
        </div>
    </header>

    <main>
        <div class="bg-image"></div>
        <div class="form-container">
            <form action="register.php" method="post">
                <h2>Sign up</h2>
                <?php if (isset($_SESSION["error"])) { ?>
                <p style="color:red;"><?php echo $_SESSION["error"]; ?></p>
                <?php unset($_SESSION["error"]); } ?>
    
                <?php if (isset($_SESSION["success"])) { ?>
                <p style="color:green;"><?php echo $_SESSION["success"]; ?></p>
                <?php unset($_SESSION["success"]); } ?>
                <p>Already have an account? <a href="login.php">Log in</a></p>
                
                <div class="input-group">
                    <label for="email">Email Address</label>
                    <div class="input-wrapper">
                        <img src="email.png" alt="email">
                        <input type="email" id="email" name="txtEmail" maxlength="50" placeholder="Enter Email" required>
                    </div>
                </div>
    
                <div class="input-group">
                    <label for="password">Password</label>
                    <div class="input-wrapper">
                        <img src="lock.png" alt="password">
                        <input type="password" id="password" name="txtPw" maxlength="18" placeholder="Enter password" required>
                    </div>
                </div>
    
                <div class="input-group">
                    <label for="confirm-password">Confirm Password</label>
                    <div class="input-wrapper">
                        <img src="lock.png" alt="confirm password">
                        <input type="password" id="confirm-password" name="txtConfirmPw" placeholder="Enter password" required>
                    </div>
                </div>
                
                <button type="submit" class="signup-button" name="register" onclick="window.location.href='shopdetails.html'">Sign up</button>
            </form>
        </div>
    </main>
    <footer>
        <div class="footer-container">
            <div class="sec sci">
                <div class="logo">
                    <img src="logo.png" width="250px">
                    <p>&copy; 2025 FoodieFinder. All rights reserved</p>
                    <ul class="icn">
                        <li><img src="twt.png" width="30px"></li>
                        <li><img src="fb.png" width="30px"></li>
                        <li><img src="yt.png" width="30px"></li>
                        <li><img src="link.png" width="30px"></li>
                    </ul>
                </div>
            </div>
            <div class="sec navigation">
                <h2>Navigation</h2>
                <ul class="navg">
                    <li><a href="index.html">Home</a></li> </br>
                    <li><a href="about.html">About Us</a></li> </br>
                    <li><a href="#">Contact Us</a></li> </br>
                    <li><a href="support.html">Support</a></li> </br>
                </ul>
            </div>
            <div class="sec help">
                <h2>Helpful Links</h2>
                <ul class="navg">
                    <li><a href="#">Privacy Policy</a></li> </br>
                    <li><a href="#">Terms and Conditions</a></li> </br>
                    <li><a href="#">FAQs</a></li> </br>
                </ul>
            </div>
        </div>
      </footer>