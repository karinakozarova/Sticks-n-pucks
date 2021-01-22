/// <reference types="cypress" />

context('Teams', () => {
  beforeEach(() => {
    cy.visit('http://localhost:8081/randomunknownpage', {failOnStatusCode: false});
  })

  it('Teams lisitng page has cards', () => {
  	cy.title().should('include', 'Error');
  	cy.contains('sticksnpucks.com');
  })
})
