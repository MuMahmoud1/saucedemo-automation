# SauceDemo Automation Framework 🚀

## Overview
End-to-end test automation framework for [SauceDemo](https://www.saucedemo.com) web application, built with Java and Selenium WebDriver following industry best practices.

## Tech Stack
| Tool | Version |
|------|---------|
| Java | 11 |
| Selenium WebDriver | 4.41 |
| TestNG | 7.12 |
| Allure Reports | 2.21 |
| Maven | 3.9 |

## Design Patterns
- **Page Object Model (POM)** — separates test logic from page interactions
- **Page Factory** — efficient element initialization
- **Builder Pattern** — fluent method chaining for readable tests
- **Data-Driven Testing** — TestNG DataProvider for multiple test scenarios

## Project Structure
```
src/
├── main/java/com/saucedemo
│   ├── base/              # BasePage & BaseTest
│   ├── factory/           # DriverFactory
│   └── pages/             # Page classes
└── test/java/com/saucedemo
    └── testcases/         # Test classes
```

## Page Classes
| Page | Responsibility |
|------|---------------|
| LoginPage | Handle login actions and validations |
| ProductsPage | Handle products listing, sorting, and cart actions |
| ProductDetailsPage | Handle single product details and add to cart |
| CartPage | Handle cart actions and validations |
| CheckoutStepOnePage | Handle checkout form inputs |
| CheckoutStepTwoPage | Handle order summary validations |
| CheckoutFinishPage | Handle order completion |
| NavigationPage | Handle burger menu and navigation |
| BasePage | Common elements shared across all pages |

## Test Coverage
| Module | Test Cases |
|--------|-----------|
| Login | 10 |
| Products | 12 |
| Product Details | 8 |
| Cart | 6 |
| Checkout | 8 |
| Navigation | 5 |
| **Total** | **46 Test Cases** |

## Known Bugs Found
| Bug | Severity |
|-----|----------|
| Checkout can be completed with empty cart | High |
| Name fields accept numbers and special characters | Medium |
| Login is case-sensitive for username | Low |

## Future Enhancements
- [ ] API Testing with RestAssured
- [ ] CI/CD Integration with GitHub Actions
- [ ] Parallel Execution with TestNG
- [ ] BDD with Cucumber
- [ ] Docker support for cross-browser testing
- [ ] Retry logic for flaky tests

## How To Run
```bash
# Run all tests
mvn clean test

# View Allure Report
allure serve target/allure-results
```

## Prerequisites
- Java 11
- Maven
- Chrome Browser
- Allure CLI
